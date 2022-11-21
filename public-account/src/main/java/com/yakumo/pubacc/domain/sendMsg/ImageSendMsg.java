package com.yakumo.pubacc.domain.sendMsg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

/**
 * Author cho1r
 * 2022/03/30 11:43
 */
@Data
@XStreamAlias("xml")
public class ImageSendMsg extends BaseSendMsg {
    /**
     * 回复图片消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[image]]></MsgType>
     *   <Image>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *   </Image>
     * </xml>
     *
     * 参数	是否必须	说明
     * ToUserName	是	接收方帐号（收到的OpenID）
     * FromUserName	是	开发者微信号
     * CreateTime	是	消息创建时间 （整型）
     * MsgType	是	消息类型，图片为image
     * MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id。
     */

    private String MediaId;

    public ImageSendMsg(Map<String, String> msg, String mediaId) {
        super(msg);
        super.msgType = "image";
        MediaId = mediaId;
    }
}
