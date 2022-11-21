#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/14 10:47

# 捕获异常

import urllib.request
import urllib.error

# url = 'https://blog.csdn.net/sulixu/article/details/119818949_'
url = 'https://blog.csddddn.net/sulixu/article/details/119818949_'

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36',
}

try:
    req = urllib.request.Request(url=url, headers=headers)
    resp = urllib.request.urlopen(req)
    content = resp.read().decode('utf-8')
    print(content)
except urllib.error.HTTPError:
    print('system updating now.')
except urllib.error.URLError:
    print('i sayed system updating now.')
