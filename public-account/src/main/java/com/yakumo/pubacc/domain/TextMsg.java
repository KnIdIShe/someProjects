package com.yakumo.pubacc.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author cho1r
 * 2022/03/29 22:43
 * 文本消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "xml")
public class TextMsg {
    /**
     * ToUserName	开发者微信号
     * FromUserName	发送方帐号（一个OpenID）
     * CreateTime	消息创建时间 （整型）, 秒
     * MsgType	消息类型，文本为text
     * Content	文本消息内容
     * MsgId	消息id，64位整型
     *
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>1348831860</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     *   <Content><![CDATA[this is a test]]></Content>
     *   <MsgId>1234567890123456</MsgId>
     * </xml>
     */
    @JacksonXmlProperty(localName = "ToUserName")
    private String ToUserName;
    @JacksonXmlProperty(localName = "FromUserName")
    private String FromUserName;
    @JacksonXmlProperty(localName = "CreateTime")
    private String CreateTime;
    @JacksonXmlProperty(localName = "MsgType")
    private String MsgType;

    @JacksonXmlProperty(localName = "Content")
    private String Content;

    @JacksonXmlProperty(localName = "MsgId")
    private String MsgId;
}
