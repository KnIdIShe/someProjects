#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:47

# URL 的编码, 多个参数

import urllib.request
import urllib.parse

baseUrl = 'https://www.baidu.com/s?'
query = {'wd': '周杰伦', 'sex': '男', 'location': 'Taiwan'}

encodedQuery = urllib.parse.urlencode(query)

url = baseUrl + encodedQuery

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'}

req = urllib.request.Request(url=url, headers=headers)
content = urllib.request.urlopen(req).read().decode('utf-8')
print(content)
