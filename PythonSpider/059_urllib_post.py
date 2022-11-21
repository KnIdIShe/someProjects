#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:47

# post 请求百度翻译建议内容

import urllib.request
import urllib.parse
import json

url = 'https://fanyi.baidu.com/sug'
data = {'kw': 'spider'}
data = urllib.parse.urlencode(data).encode('utf-8')

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'}

req = urllib.request.Request(url=url, data=data, headers=headers)
content = urllib.request.urlopen(req).read().decode('utf-8')

# str --> json obj
obj = json.loads(content)
print(obj)
