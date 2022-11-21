#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/15 19:11

# 解析, xpath, 获取百度热搜

import urllib.request

from lxml import etree

url = 'http://top.baidu.com/board?tab=realtime'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36',
}

req = urllib.request.Request(url=url, headers=headers)
resp = urllib.request.urlopen(req)
# 1. 获取网页源码
content = resp.read().decode('utf-8')

# 2. 解析服务器响应 resp
tree = etree.HTML(content)

# 3. 获取想获取的数据
# result = tree.xpath('//input[@id="su"]/@value')
result = tree.xpath('//div[@class="c-single-text-ellipsis"]/text()')
print(result)





