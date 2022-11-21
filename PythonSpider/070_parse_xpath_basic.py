#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/15 19:11

# 解析, xpath

from lxml import etree

tree = etree.parse('070_parse_xpath_basic.html')

# 查找所有 ul > li
# li_list = tree.xpath('//body/ul/li')
# print(li_list)
# print(len(li_list))

# 查找所有有 id 的 li 标签
# li_list = tree.xpath('//ul/li[@id="l1"]/text()')
# print(li_list)
# print(len(li_list))

# 查找所有 id 为 l1 的 li 标签的 class 属性值
# li_list = tree.xpath('//ul/li[@id="l1"]/@class')
# print(li_list)
# print(len(li_list))

# 模糊查询, 查找所有 id 包含 c 的 li 标签
# li_list = tree.xpath('//ul/li[contains(@id, "c")]/text()')
# print(li_list)
# print(len(li_list))

# 模糊查询, 查找所有 id 以 c 开头 的 li 标签
# li_list = tree.xpath('//ul/li[starts-with(@id, "c")]/text()')
# print(li_list)
# print(len(li_list))

# 逻辑运算, 查找所有 id 以 c 开头 的 li 标签
# li_list = tree.xpath('//ul/li[@id="l1" and @class="c1"]/text()')
# li_list = tree.xpath('//ul/li[@id="l1" or @id="l2"]/text()')
li_list = tree.xpath('//title/text() | //p/text()')
print(li_list)
print(len(li_list))



