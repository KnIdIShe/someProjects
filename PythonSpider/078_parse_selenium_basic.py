#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/20 20:36

#

from selenium import webdriver
from selenium.webdriver.chrome.service import Service

# 创建浏览器对象

service = Service('chromedriver.exe')
browser = webdriver.Chrome(service=service)

# 访问网址
# url = 'https://www.baidu.com'
# browser.get(url)

url = 'https://www.jd.com/'
browser.get(url)

content = browser.page_source
print(content)
