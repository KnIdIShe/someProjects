#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# 海龟绘图

# 导入turtle包的所有内容:
from turtle import *

# 设置笔刷宽度:
# width(4)
#
# # 前进:
# forward(200)
# # 右转90度:
# right(90)
#
# # 笔刷颜色:
# pencolor('red')
# forward(100)
# right(90)
#
# pencolor('green')
# forward(200)
# right(90)
#
# pencolor('blue')
# forward(100)
# right(90)
#
# # 调用done()使得窗口等待被关闭，否则将立刻关闭窗口:
# done()


# 绘制5个五角星
# def drawStar(x, y):
#     pu()  # penup 抬起画笔，之后移动画笔不绘制形状
#     goto(x, y)  # 移动到某个位置；参数为对应点的坐标
#     pd()  # pendown 落下画笔，之后移动画笔将绘制形状
#     # set heading: 0
#     seth(0)  # 设置小海龟当前行进的方向,该角度是绝对方向角度值。
#     for i in range(5):
#         fd(40)  # forward 向小海龟当前行进方向前进distance距离
#         rt(144)  # right 在海龟当前头的方向上再向右转
#
#
# # 水平绘制5个
# for x in range(0, 250, 50):
#     drawStar(x, 0)
#
# done()


# 绘制一棵分型树

# tilt('给我一点时间，还你一棵树')
# # 设置色彩模式是RGB, 为随机生成RGB色彩做准备
# colormode(255)
#
# lt(90)  # left
#
# lv = 14
# l = 120
# s = 45
#
# width(lv)  # 设置笔刷宽度
#
# # 初始化RGB颜色:
# r = 0
# g = 0
# b = 0
# pencolor(r, g, b)
#
# penup()
# bk(l)  # backward
# pendown()
# fd(l)
#
#
# def draw_tree(l, level):
#     global r, g, b
#     # save the current pen width
#     w = width()
#
#     # narrow the pen width
#     width(w * 3.0 / 4.0)
#     # set color:
#     r = r + 1
#     g = g + 2
#     b = b + 3
#     pencolor(r % 200, g % 200, b % 200)
#
#     l = 3.0 / 4.0 * l
#
#     lt(s)
#     fd(l)
#
#     if level < lv:
#         draw_tree(l, level + 1)
#     bk(l)
#     rt(2 * s)
#     fd(l)
#
#     if level < lv:
#         draw_tree(l, level + 1)
#     bk(l)
#     lt(s)
#
#     # restore the previous pen width
#     width(w)
#
#
# # speed("fastest")
# speed(10)
#
# draw_tree(l, 4)
#
# done()


# 秒表
import time

ht()

speed(0)

penup()

goto(0, 120)

pendown()

for i in range(12):

    right(90)

    forward(10)

    backward(10)

    left(90)

    for j in range(4):
        circle(-120, 6)

        right(90)

        forward(5)

        backward(5)

        left(90)

    circle(-120, 6)

penup()

goto(0, 0)

pendown()


def pin(p, long, angle):
    p.left(90 - angle)

    p.forward(long)


def undopin(p):
    for _ in range(2):
        p.undo()


fen = clone()

miao = clone()

miaolong = 100

fenlong = 60

miaoang = 0

fenang = 0

while True:

    pin(fen, fenlong, fenang)

    for i in range(60):
        pin(miao, miaolong, miaoang + (i * 6))

        time.sleep(0.93)

        undopin(miao)

    undopin(fen)

    fenang += 6
