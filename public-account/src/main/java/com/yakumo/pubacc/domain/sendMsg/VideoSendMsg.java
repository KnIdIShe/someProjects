package com.yakumo.pubacc.domain.sendMsg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

/**
 * Author cho1r
 * 2022/03/30 11:16
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class VideoSendMsg extends BaseSendMsg {
    /**
     * 回复视频消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[video]]></MsgType>
     *   <Video>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *     <Title><![CDATA[title]]></Title>
     *     <Description><![CDATA[description]]></Description>
     *   </Video>
     * </xml>
     *
     * 参数	是否必须	说明
     * ToUserName	是	接收方帐号（收到的OpenID）
     * FromUserName	是	开发者微信号
     * CreateTime	是	消息创建时间 （整型）
     * MsgType	是	消息类型，视频为video
     * MediaId	是	通过素材管理中的接口上传多媒体文件，得到的id
     * Title	否	视频消息的标题
     * Description	否	视频消息的描述
     */

    private String MediaId;
    private String Title;
    private String Description;

    public VideoSendMsg(Map<String, String> msg, String mediaId, String title, String description) {
        super(msg);
        super.msgType = "video";
        MediaId = mediaId;
        Title = title;
        Description = description;
    }
}
