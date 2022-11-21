#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 操作文件和目录

import os

# print(os.name)
# print(os.uname())  # Windows上不提供

# print(os.environ)
# print(os.environ.get('JAVA_HOME'))
# print(os.environ.get('MAVEN_HOME', 'None'))

# 查看当前目录的绝对路径:
# print(os.path.abspath('.'))
# 在某个目录下创建一个新目录，首先把新目录的完整路径表示出来:
# print(os.path.join(r'E:\myWork\py\IO', 'testdir'))
# 然后创建一个目录:
# os.mkdir(r'E:\myWork\py\IO\testdir')
# 删掉一个目录:
# os.rmdir(r'E:\myWork\py\IO\testdir')
# 拆分路径
# print(os.path.split(r'E:\myWork\py\IO\testdir'))
# 文件扩展名
# print(os.path.splitext(r'E:\myWork\py\IO\testdir\te.txt'))
# 对文件重命名:
# os.rename(r'E:\myWork\py\IO\te.txt', r'E:\myWork\py\IO\te')
# 删掉文件:
# os.remove(r'./te')

# 复制文件
# import shutil
#
# shutil.copyfile(r'./gbk.txt', r'te.txt')

# 列出当前目录下的所有目录
# print([x for x in os.listdir('.') if os.path.isdir(x)])

# 列出所有的.py文件
# print([x for x in os.listdir('.') if os.path.isfile(x) and os.path.splitext(x)[1] == '.py'])


# test 2
# 编写一个程序，能在当前目录以及当前目录的所有子目录下查找文件名包含指定字符串的文件，并打印出相对路径。


# def find_file(L, dir=r'E:\myWork\py\IO\te'):
#     for x in os.listdir(dir):
#         # 当前文件对象是文件
#         if os.path.isfile(x):
#             # 文件名
#             filename = os.path.splitext(x)[0]
#             # 文件名不包含指定字符串
#             if index := filename.find('te') == -1:
#                 continue
#             else:
#                 L.append(get_rela_path(x))
#         else:
#             # 文件夹
#             find_file(L, x)
#
#
# # 获取相对路径
# def get_rela_path(x):
#     # 绝对路径
#     abs_path = os.path.abspath(x)
#     # 根路径
#     root_path = os.path.abspath('.')
#     rela_path = abs_path.replace(root_path, '.', 1)
#     # 转换 .\\te.txt 为 .\te.txt
#     # rela_path = rela_path.replace('\\\\', '/')
#
#     return rela_path
#
# # 存放包含指定字符串的文件路路径
# L = []
# find_file(L)
# print(L)


# def find_file(key='te', dir='.'):
#     for root, dirs, files in os.walk(dir):
#         for x in files:
#             if key in os.path.splitext(x)[0]:
#                 # print(os.path.abspath(x).replace(os.path.abspath(dir), '.'))
#                 print(os.path.abspath(x))

# for x in dirs:
#     if key in os.path.splitext(x)[0]:
#         print(os.path.abspath(x).replace(os.path.abspath(dir), '.'))

# find_file()

# def searchfiles(rootdir='.', filename='te'):
#     findresult = []  # 查询的结果集,包含查询字符串的文件可能很多
#     for item in os.listdir(rootdir):
#         reladir = os.path.join(rootdir, item)  # 相对路径
#
#         if os.path.isdir(reladir):
#             findresult.extend(searchfiles(reladir, filename))  # 如果是目录，递归调用
#
#         fname = os.path.splitext(item)[0]  # 文件名
#         if filename in fname:
#             findresult.append(reladir)
#
#     return findresult


# a = searchfiles()
# print(a)


import os


# def outputDir(dir, a):
#     if os.path.isdir(dir):
#         d = os.listdir(dir)
#         for f in d:
#             a.append(f)
#             outputDir(os.path.join(dir, f), a)
# a = []
#
#
# outputDir('.', a)
# print(a)


def dir(path='.'):
    for i in os.listdir(path):
        if os.path.isdir(i):
            print(i + '/')
            dir(os.path.abspath(i))
        else:
            print(i)


dir()
