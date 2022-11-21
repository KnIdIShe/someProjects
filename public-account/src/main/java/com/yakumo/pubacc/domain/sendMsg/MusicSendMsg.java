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
public class MusicSendMsg extends BaseSendMsg {
    /**
     * 回复音乐消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[music]]></MsgType>
     *   <Music>
     *     <Title><![CDATA[TITLE]]></Title>
     *     <Description><![CDATA[DESCRIPTION]]></Description>
     *     <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     *     <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     *     <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     *   </Music>
     * </xml>
     *
     * 参数	是否必须	说明
     * ToUserName	是	接收方帐号（收到的OpenID）
     * FromUserName	是	开发者微信号
     * CreateTime	是	消息创建时间 （整型）
     * MsgType	是	消息类型，音乐为music
     * Title	否	音乐标题
     * Description	否	音乐描述
     * MusicURL	否	音乐链接
     * HQMusicUrl	否	高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * ThumbMediaId	是	缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */

    private String Music;

    public MusicSendMsg(Map<String, String> msg, String music) {
        super(msg);
        super.msgType = "music";
        Music = music;
    }
}
