#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 文件读写

# try:
#     f = open(r'E:\myWork\py\IO\te.txt', 'r')
#     print(f.read())
# finally:
#     if f:
#         f.close()


# with open(r'E:\myWork\py\IO\te.txt', 'r') as f:
#     print(f.read())


# with open(r'E:\myWork\py\IO\te.txt', 'r') as f:
#     for line in f.readlines():
#         # print(line)
#         print(line.strip())  # 把末尾的'\n'删掉


# with open(r'./Christmas Card 19.png', 'rb') as f:
#     print(f.read())

# with open(r'E:\myWork\py\IO\gbk.txt', 'r', encoding='gbk', errors='ignore') as f:
#     print(f.read())


with open(r'E:\myWork\py\IO\te.txt', 'a') as f:
    f.write('hello tom')
