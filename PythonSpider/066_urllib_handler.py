#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/15 17点26分

# 使用 handler 访问百度

import urllib.request

url = 'http://www.baidu.com'

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/99.0.4844.51 Safari/537.36',
}

req = urllib.request.Request(url=url, headers=headers)

# 获取 handler 对象
handler = urllib.request.HTTPHandler()
# 获取 opener 对象
opener = urllib.request.build_opener(handler)
# 调用 open 方法
resp = opener.open(req)

content = resp.read().decode('utf-8')
print(content)
