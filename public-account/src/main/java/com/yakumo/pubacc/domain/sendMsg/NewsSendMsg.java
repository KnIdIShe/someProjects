package com.yakumo.pubacc.domain.sendMsg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * Author cho1r
 * 2022/03/30 11:16
 */
@Data
@ToString(callSuper = true)
@XStreamAlias("xml")
public class NewsSendMsg extends BaseSendMsg {
    /**
     * 回复图文消息
     * <xml>
     * <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime>
     * <MsgType><![CDATA[news]]></MsgType>
     * <ArticleCount>1</ArticleCount>
     * <Articles>
     * <item>
     * <Title><![CDATA[title1]]></Title>
     * <Description><![CDATA[description1]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl>
     * <Url><![CDATA[url]]></Url>
     * </item>
     * </Articles>
     * </xml>
     * <p>
     * 参数	是否必须	说明
     * ToUserName	是	接收方帐号（收到的OpenID）
     * FromUserName	是	开发者微信号
     * CreateTime	是	消息创建时间 （整型）
     * MsgType	是	消息类型，图文为news
     * ArticleCount	是	图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     * Articles	是	图文消息信息，注意，如果图文数超过限制，则将只发限制内的条数
     * Title	是	图文消息标题
     * Description	是	图文消息描述
     * PicUrl	是	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     * Url	是	点击图文消息跳转链接
     */

    @XStreamAlias("ArticleCount")
    private int articleCount;
    @XStreamAlias("Articles")
    private List<Article> articles;

    public NewsSendMsg(Map<String, String> msg, List<Article> articles) {
        super(msg);
        super.msgType = "news";
        this.articleCount = articles.size();
        this.articles = articles;
    }
}
