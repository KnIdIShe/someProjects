#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/20 20:36

#
import gzip
import urllib.request
from io import BytesIO

# url = 'https://www.jd.com/'

url = 'https://www.bilibili.com/video/BV1Db4y1m7Ho?p=78'
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36'
}
req = urllib.request.Request(url=url, headers=headers)
resp = urllib.request.urlopen(req)
content = resp.read()

if resp.info().get('Content-Encoding') == 'gzip':
    # 打印原始网页内容
    # print('原始网页内容： %s' % content)

    # 将压缩的内容写入内存，作为BytesIO对象，后面作为参数传入GzipFile对象
    buff = BytesIO(content)
    # 解压缩
    f = gzip.GzipFile(fileobj=buff)
    # 对逐个字节进行解压
    content = f.read().decode('utf-8')

# 打印网页内容
print('解码后的网页内容： %s' % content)

# content = resp.read().decode('utf-8')
# print(content)
