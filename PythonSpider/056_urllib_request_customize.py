#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 09:41

# 定制请求对象, User-Agents

import urllib.request

url = 'https://www.baidu.com'
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36'}

# 定制请求对象
req = urllib.request.Request(url=url, headers=headers)

resp = urllib.request.urlopen(req)
content = resp.read().decode('utf-8')
print(content)
