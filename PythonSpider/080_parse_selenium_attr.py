#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/20 20:36

# 界面交互

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

# 创建浏览器对象

service = Service('chromedriver.exe')
browser = webdriver.Chrome(service=service)

# 访问网址
url = 'https://www.baidu.com'
browser.get(url)

button = browser.find_element(By.ID, 'su')
# print(button.get_attribute('class'))
# print(button.tag_name)

# a = browser.find_element(By.LINK_TEXT, '新闻')
# print(a.text)

