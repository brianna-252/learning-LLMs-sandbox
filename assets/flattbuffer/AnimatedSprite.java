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
public final class AnimatedSprite extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_23_5_26(); }
  public static AnimatedSprite getRootAsAnimatedSprite(ByteBuffer _bb) { return getRootAsAnimatedSprite(_bb, new AnimatedSprite()); }
  public static AnimatedSprite getRootAsAnimatedSprite(ByteBuffer _bb, AnimatedSprite obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public AnimatedSprite __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public long index() { int o = __offset(6); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }
  public int set() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public long direction() { int o = __offset(10); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }
  public long action() { int o = __offset(12); return o != 0 ? (long)bb.getInt(o + bb_pos) & 0xFFFFFFFFL : 0L; }
  public Sprite sprites() { return sprites(new Sprite()); }
  public Sprite sprites(Sprite obj) { int o = __offset(14); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createAnimatedSprite(FlatBufferBuilder builder,
      int nameOffset,
      long index,
      int set,
      long direction,
      long action,
      int spritesOffset) {
    builder.startTable(6);
    AnimatedSprite.addSprites(builder, spritesOffset);
    AnimatedSprite.addAction(builder, action);
    AnimatedSprite.addDirection(builder, direction);
    AnimatedSprite.addSet(builder, set);
    AnimatedSprite.addIndex(builder, index);
    AnimatedSprite.addName(builder, nameOffset);
    return AnimatedSprite.endAnimatedSprite(builder);
  }

  public static void startAnimatedSprite(FlatBufferBuilder builder) { builder.startTable(6); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addIndex(FlatBufferBuilder builder, long index) { builder.addInt(1, (int) index, (int) 0L); }
  public static void addSet(FlatBufferBuilder builder, int set) { builder.addInt(2, set, 0); }
  public static void addDirection(FlatBufferBuilder builder, long direction) { builder.addInt(3, (int) direction, (int) 0L); }
  public static void addAction(FlatBufferBuilder builder, long action) { builder.addInt(4, (int) action, (int) 0L); }
  public static void addSprites(FlatBufferBuilder builder, int spritesOffset) { builder.addOffset(5, spritesOffset, 0); }
  public static int endAnimatedSprite(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public AnimatedSprite get(int j) { return get(new AnimatedSprite(), j); }
    public AnimatedSprite get(AnimatedSprite obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

