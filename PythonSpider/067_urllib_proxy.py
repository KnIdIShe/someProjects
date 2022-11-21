#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/15 17点33分

# 代理

import urllib.request

url = 'http://www.baidu.com/s?wd=ip'

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) '
                  'Chrome/99.0.4844.51 Safari/537.36',
}

req = urllib.request.Request(url=url, headers=headers)

proxies = {
    'http': '39.105.96.177:3128'
}

handler = urllib.request.ProxyHandler(proxies=proxies)
opener = urllib.request.build_opener(handler)
resp = opener.open(req)

# resp = urllib.request.urlopen(req)

content = resp.read().decode('utf-8')

with open('resource/proxy.html', 'w', encoding='utf-8') as f:
    f.write(content)
