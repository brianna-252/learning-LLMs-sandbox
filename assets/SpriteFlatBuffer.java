package assets;

import assets.flattbuffer.*;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

public class SpriteFlatBuffer {
    private static String spriteJson = "assets/flatbuffer/spritesheetf";

    private static boolean notLoaded = false;
    private static final HashMap<String, HashMap<Integer, Sprite>> sprites;
//    private static final HashMap<String, HashMap<Integer, Sprite>> animatedSprites;

    /**
     * Static class used to load the flat buffer file.
     */
    static {
        sprites = new HashMap<>();
//        animatedSprites = new HashMap<>();
        readFlatBuffer();
    }

    /**
     * Loads the flatBuffer file into HashMap data structure.
     */
    private static void readFlatBuffer() {
        File file = new File(spriteJson);
        if (!file.exists()) {
            notLoaded = true;
            return;
        }
        if (sprites != null) sprites.clear();
//        if (animatedSprites != null) animatedSprites.clear();
        byte[] data;
        try {
            RandomAccessFile f = new RandomAccessFile(file, "r");
            data = new byte[(int) f.length()];
            f.readFully(data);
            f.close();
        } catch (IOException e) {
            notLoaded = false;
            return;
        }

        ByteBuffer buf = ByteBuffer.wrap(data);
        SpriteSheetRoot ssr = SpriteSheetRoot.getRootAsSpriteSheetRoot(buf);

        decodeSheet(ssr);
    }

    /**
     * Decodes spritesheetf into sprite objects
     *
     * @param ssr root flat buffer object.
     */
    private static void decodeSheet(SpriteSheetRoot ssr) {
        int spriteSheetSize = ssr.spritesLength();
        for (int i = 0; i < spriteSheetSize; i++) {
            SpriteSheet spriteSheet = ssr.sprites(i);
            int spritSize = spriteSheet.spritesLength();
            String name = spriteSheet.name();

            HashMap<Integer, Sprite> map = sprites.computeIfAbsent(name, k -> new HashMap<>());
            for (int j = 0; j < spritSize; j++) {
                try {
                    Sprite sprite = getSprite(spriteSheet.sprites(j));
                    map.put(sprite.index(), sprite);
                } catch (Exception e) {
                    System.out.println(name);
                }
            }
        }

        int animatedLength = ssr.animatedSpritesLength();
        for (int i = 0; i < animatedLength; i++) {
            AnimatedSprite animatedSheet = ssr.animatedSprites(i);
            String name = animatedSheet.name();
            HashMap<Integer, Sprite> map = sprites.computeIfAbsent(name, k -> new HashMap<>());

            assets.flattbuffer.Sprite s = animatedSheet.sprites();
            Sprite sprite = getSprite(s);
            sprite.index = (int) animatedSheet.index();
            map.put(sprite.index(), sprite);
        }
    }

    public static void main(String[] args) throws IOException {
    }

    /**
     * Gets the sprite object from parsed buffer.
     *
     * @param s Buffer sprite object to be extracted
     * @return Sprite object containing sprite data.
     */
    private static Sprite getSprite(assets.flattbuffer.Sprite s) {
        Sprite newSprite = new Sprite();
        newSprite.index = s.index();
        newSprite.aId = (int) s.aId();
        Position position = s.position();
        newSprite.setPosition(position.w(), position.h(), position.x(), position.y());
        Color color = s.mostCommonColor();
        newSprite.setColor(color.r(), color.g(), color.b(), color.a());

        return newSprite;
    }

    /**
     * Retrieves sprite coordinates used in sprite atlases based on sprite group name and index.
     *
     * @param name  Name of the sprite group.
     * @param index Index of the sprite in the group.
     * @return Integer
     */
    public int[] getSpriteData(String name, int index) {
        if (notLoaded) return null;
        HashMap<Integer, Sprite> list = sprites.get(name);
//        if (list == null) {
//            list = animatedSprites.get(name);
//        }
        Sprite sprite = list.get(index);
        return new int[]{sprite.positionX, sprite.positionY, sprite.positionW, sprite.positionH, sprite.aId};
    }

    /**
     * Retrieves sprite most common color.
     *
     * @param name  Name of the sprite group.
     * @param index Index of the sprite in the group.
     * @return Integer
     */
    public float[] getSpriteColor(String name, int index) {
        if (notLoaded) return null;
        HashMap<Integer, Sprite> list = sprites.get(name);
        Sprite sprite = list.get(index);
        return sprite.colorAsInt();
    }

    static class Sprite {
        int padding;
        int index;
        int aId;
        boolean isT;
        int positionW;
        int positionH;
        int positionX;
        int positionY;
        int maskPositionW;
        int maskPositionH;
        int maskPositionX;
        int maskPositionY;
        float mostCommonColorR;
        float mostCommonColorG;
        float mostCommonColorB;
        float mostCommonColorA;
        float[] color = new float[4];

        int animatedIndex;
        int animatedDirection;
        String animatedAction;
        int animatedSet;

        public void setAnimationVars(int index, int direction, String action, int set) {
            animatedIndex = index;
            animatedDirection = direction;
            animatedAction = action;
            animatedSet = set;
        }

        public void setPosition(float w, float h, float x, float y) {
            positionW = (int) w;
            positionH = (int) h;
            positionX = (int) x;
            positionY = (int) y;
        }

        public void setColor(float r, float g, float b, float a) {
            mostCommonColorR = r;
            mostCommonColorG = g;
            mostCommonColorB = b;
            mostCommonColorA = a;
            color[0] = r;
            color[1] = g;
            color[2] = b;
            color[3] = a;
        }

        public float[] colorAsInt() {
            return color;
        }

        public int index() {
            return index;
        }
    }
}
