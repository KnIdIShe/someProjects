package com.yakumo.pubacc.domain.sendMsg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Author cho1r
 * 2022/03/30 11:09
 */
@Data
@NoArgsConstructor
public class BaseSendMsg {
    /**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     * </xml>
     *
     * 参数	是否必须	描述
     * ToUserName	是	接收方帐号（收到的OpenID）
     * FromUserName	是	开发者微信号
     * CreateTime	是	消息创建时间 （整型）
     * MsgType	是	消息类型，文本为text
     */

//    @JacksonXmlProperty(localName = "ToUserName")
    @XStreamAlias("ToUserName")
    public String toUserName;

//    @JacksonXmlProperty(localName = "FromUserName")
    @XStreamAlias("FromUserName")
    public String fromUserName;
//    @JacksonXmlProperty(localName = "CreateTime")
    @XStreamAlias("CreateTime")
    public String createTime;

//    @JacksonXmlProperty(localName = "MsgType")
    @XStreamAlias("MsgType")
    public String msgType;

    public BaseSendMsg(Map<String, String> msg) {
        toUserName = msg.get("FromUserName");
        fromUserName = msg.get("ToUserName");
        createTime = System.currentTimeMillis() / 1000 + "";
    }
}
