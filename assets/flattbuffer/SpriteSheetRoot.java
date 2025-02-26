// automatically generated by the FlatBuffers compiler, do not modify

package assets.flattbuffer;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class SpriteSheetRoot extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static SpriteSheetRoot getRootAsSpriteSheetRoot(ByteBuffer _bb) { return getRootAsSpriteSheetRoot(_bb, new SpriteSheetRoot()); }
  public static SpriteSheetRoot getRootAsSpriteSheetRoot(ByteBuffer _bb, SpriteSheetRoot obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public SpriteSheetRoot __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public SpriteSheet sprites(int j) { return sprites(new SpriteSheet(), j); }
  public SpriteSheet sprites(SpriteSheet obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int spritesLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public SpriteSheet.Vector spritesVector() { return spritesVector(new SpriteSheet.Vector()); }
  public SpriteSheet.Vector spritesVector(SpriteSheet.Vector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  public AnimatedSprite animatedSprites(int j) { return animatedSprites(new AnimatedSprite(), j); }
  public AnimatedSprite animatedSprites(AnimatedSprite obj, int j) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int animatedSpritesLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public AnimatedSprite.Vector animatedSpritesVector() { return animatedSpritesVector(new AnimatedSprite.Vector()); }
  public AnimatedSprite.Vector animatedSpritesVector(AnimatedSprite.Vector obj) { int o = __offset(6); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }

  public static int createSpriteSheetRoot(FlatBufferBuilder builder,
      int spritesOffset,
      int animatedSpritesOffset) {
    builder.startTable(2);
    SpriteSheetRoot.addAnimatedSprites(builder, animatedSpritesOffset);
    SpriteSheetRoot.addSprites(builder, spritesOffset);
    return SpriteSheetRoot.endSpriteSheetRoot(builder);
  }

  public static void startSpriteSheetRoot(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addSprites(FlatBufferBuilder builder, int spritesOffset) { builder.addOffset(0, spritesOffset, 0); }
  public static int createSpritesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startSpritesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addAnimatedSprites(FlatBufferBuilder builder, int animatedSpritesOffset) { builder.addOffset(1, animatedSpritesOffset, 0); }
  public static int createAnimatedSpritesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startAnimatedSpritesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endSpriteSheetRoot(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
  public static void finishSpriteSheetRootBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedSpriteSheetRootBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public SpriteSheetRoot get(int j) { return get(new SpriteSheetRoot(), j); }
    public SpriteSheetRoot get(SpriteSheetRoot obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

