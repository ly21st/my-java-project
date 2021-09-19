import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @description: DiscardServerHandler
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-08 14:00
 **/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
         ((ByteBuf)msg).release();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // ((ByteBuf)msg).release();
        ByteBuf in = (ByteBuf)msg;
        try {
            System.out.println(in.toString(CharsetUtil.UTF_8));
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // ((ByteBuf)msg).release();
        ByteBuf in = (ByteBuf)msg;
        try {
            System.out.println(in.toString(CharsetUtil.UTF_8));
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
    */

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}


















