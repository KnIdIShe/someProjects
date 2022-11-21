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
public class TextSendMsg extends BaseSendMsg {
    /**
     * 回复文本消息
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     *   <Content><![CDATA[你好]]></Content>
     * </xml>
     *
     * 参数	是否必须	描述
     * ToUserName	是	接收方帐号（收到的OpenID）
     * FromUserName	是	开发者微信号
     * CreateTime	是	消息创建时间 （整型）
     * MsgType	是	消息类型，文本为text
     * Content	是	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */

    @XStreamAlias("Content")
    private String content;

    public TextSendMsg(Map<String, String> msg, String content) {
        super(msg);
        super.msgType = "text";
        this.content = content;
    }
}
