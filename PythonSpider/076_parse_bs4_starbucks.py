#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/20 20:11

# 爬取星巴克产品列表

import urllib.request
from bs4 import BeautifulSoup

url = 'https://www.starbucks.com.cn/menu/'
resp = urllib.request.urlopen(url)
content = resp.read().decode('utf-8')

soup = BeautifulSoup(content, 'lxml')

# //ul[@class="grid padded-3 product"]//strong//text()
names = soup.select('ul[class="grid padded-3 product"] strong')
for i in names:
    print(i.get_text())