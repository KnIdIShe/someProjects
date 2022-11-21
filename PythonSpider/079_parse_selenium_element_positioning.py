#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/20 20:36

# 元素定位

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

# 创建浏览器对象

service = Service('chromedriver.exe')
browser = webdriver.Chrome(service=service)

# 访问网址
url = 'https://www.baidu.com'
browser.get(url)

# button = browser.find_element_by_id('su')
# button = browser.find_element(By.ID, 'su')
# print(button)

# name = browser.find_element_by_name('wd')
# name = browser.find_element(By.NAME, 'wd')
# print(name)

# button = browser.find_element_by_xpath('//input[@id="su"]')
# button = browser.find_element(By.XPATH, '//input[@id="su"]')
# print(button)

# inputs = browser.find_elements(By.TAG_NAME, 'input')
# print(inputs)

# button = browser.find_element(By.CSS_SELECTOR, '#su')
# print(button)

button = browser.find_element(By.LINK_TEXT, '新闻')
print(button)
