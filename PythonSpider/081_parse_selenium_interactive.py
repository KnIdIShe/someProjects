#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# Author: amihso
# Date  : 2022/04/20 20:36

# 界面交互

from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
import time

# 创建浏览器对象
service = Service('chromedriver.exe')
browser = webdriver.Chrome(service=service)

# 访问网址
url = 'https://www.baidu.com'
browser.get(url)

time.sleep(2)

# 文本框中输入
input_ = browser.find_element(By.ID, 'kw')
input_.send_keys('周杰伦')
time.sleep(2)
# 点击
button = browser.find_element(By.ID, 'su')
button.click()
time.sleep(2)
# 滑到底部
js2buttom = 'document.documentElement.scrollTop=100000'
browser.execute_script(js2buttom)
time.sleep(2)
# 点击下一页
next = browser.find_element(By.XPATH, '//a[@class="n"]')
next.click()
time.sleep(2)
# 回退
browser.back()
time.sleep(2)
# 前进
browser.forward()
time.sleep(2)
# 退出浏览器
browser.quit()
