#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# print("hello, world.")

# name = input('plz input ur name: ')
# print('hello,', name)

# print absolute value of an integer:
# a = int(input('plz input a num: '))
# if a >= 0:
#     print(a)
# else:
#     print(-a)

# print('''line1
# line2
# line3''')

# print('这种')

# print('%2d-%02d' % (3, 1))
# print('%.2f' % 3.1415926)

# s1 = 72
# s2 = 85
# r = (s2 - s1) / s1 * 100
# print('%.1f' % r)

# age = 3
# if age >= 18:
#     print('adult')
# elif age >= 6:
#     print('teenager')
# else:
#     print('kid')

# s = input('birth: ')
# birth = int(s)
# if birth < 2000:
#     print('00前')
# else:
#     print('00后')

# height = 1.75
# weight = 80.5
#
# bmi = weight / (height * height)
# if bmi < 18.5:
#     print('过轻')
# elif bmi < 25:
#     print('正常')
# elif bmi < 28:
#     print('过重')
# elif bmi < 32:
#     print('肥胖')
# else:
#     print('严重肥胖')

# sum = 0
# for x in range(101):
#     # sum += x
#     sum = sum + x
# print(sum)

# sum = 0
# n = 99
# while n > 0:
#     sum = sum + n
#     n = n - 2
# print(sum)

# sum = 0
# for x in range(1, 100, 2):
#     # sum += x
#     sum = sum + x
# print(sum)

# L = ['Bart', 'Lisa', 'Adam']
# for name in L:
#     print(name)

# def age():
#     age = int(input('plz input ur age: '))
#     if age >= 18:
#         print('adult')
#         # return 'adult'
#     elif age >= 6:
#         print('teenager')
#         # return 'teenager'
#     else:
#         print('kid')
#         # return 'kid'

# from age import age
#
# age()

# def nop():
#     pass

# import math
#
#
# def move(x, y, step, angle=0):
#     nx = x + step * math.cos(angle)
#     ny = y + step * math.sin(angle)
#     return nx, ny
#
#
# np = move(0, 0, 10, math.pi / 6)
#
# print('%.2f, %.2f' % np)

# import math
#
#
# def quadratic(a, b, c):
#     deltaSqrt = math.sqrt(b ** 2 - 4 * a * c)
#     return (-b + deltaSqrt) / 2 / a, (-b - deltaSqrt) / 2 / a
#
#
# # 测试:
# print('quadratic(2, 3, 1) =', quadratic(2, 3, 1))
# print('quadratic(1, 3, -4) =', quadratic(1, 3, -4))
#
# if quadratic(2, 3, 1) != (-0.5, -1.0):
#     print('测试失败')
# elif quadratic(1, 3, -4) != (1.0, -4.0):
#     print('测试失败')
# else:
#     print('测试成功')

# def power(x, n):
#     s = 1
#     c = 1
#     while c <= n:
#         s = s * x
#         c = c + 1
#     # return s
#     print(s)

# def power(x, n=2):
#     s = 1
#     while n > 0:
#         n = n - 1
#         s = s * x
#     # return s
#     print(s)


# power(5, 3)
# power(5)

# def enroll(name, gender, age=6, city='Beijing'):
#     print('name:', name)
#     print('gender:', gender)
#     print('age:', age)
#     print('city:', city)
#
#
# enroll('tom', 'M', 11)

# def add_end(L=[]):
#     L.append('END')
#     print(L)

# def add_end(L=None):
#     if L is None:
#         L = []
#     L.append('END')
#     print(L)
#
#
# add_end()
# add_end(['a'])
# add_end()

# def calc(*numbers):
#     sum = 0
#     for n in numbers:
#         sum = sum + n * n
#     print(sum)


# calc(1, 2, 3, 4)
# calc()
# nums = [1, 2, 3, 4]
# calc(*nums)

# def person(name, age, **kw):
#     print('name:', name, 'age:', age, 'other:', kw)


# extra = {'city': 'shanghai', 'job': 'Engineer'}
# person('Michael', 30)
# person('Michael', 30, city='shanghai')
# person('Michael', 30, **extra)

# def person(name, age, *, city, job):
#     print(name, age, city, job)
#
# person('Jack', 24, city='Beijing', job='Engineer')

# def person(name, age, *args, city, job):
#     print(name, age, args, city, job)

# def person(name, age, *, city='shanghai', job):
#     print(name, age, city, job)
#
# person('Jack', 24, job='Engineer')
#
# def mul(x, *y):
#     if len(y) == 0:
#         return x
#     for i in y:
#         x = x * i
#     return x
#
#
# # 测试
# print('mul(5) =', mul(5))
# print('mul(5, 6) =', mul(5, 6))
# print('mul(5, 6, 7) =', mul(5, 6, 7))
# print('mul(5, 6, 7, 9) =', mul(5, 6, 7, 9))
# if mul(5) != 5:
#     print('测试失败!')
# elif mul(5, 6) != 30:
#     print('测试失败!')
# elif mul(5, 6, 7) != 210:
#     print('测试失败!')
# elif mul(5, 6, 7, 9) != 1890:
#     print('测试失败!')
# else:
#     try:
#         mul()
#         print('测试失败!')
#     except TypeError:
#         print('测试成功!')

# n!
# def fact(n):
#     if n == 1:
#         return 1
#     return n * fact(n - 1)

# def fact(n):
#     return fact_iter(n, 1)
#
#
# def fact_iter(num, product):
#     if num == 1:
#         return product
#     return fact_iter(num - 1, num * product)

# 1² + 2² + ... + n²
# def fact(n):
#     return fact_iter(n - 1, n * n)
#
#
# def fact_iter(num, product):
#     if num == 0:
#         return product
#     return fact_iter(num - 1, num * num + product)
#
#
# print(fact(2))

# def move(n, a, b, c):
#     if n == 1:
#         print(a, '-->', c)
#     else:
#         move(n - 1, a, c, b)
#         move(1, a, b, c)
#         move(n - 1, b, a, c)


# 期待输出:
# A --> C
# A --> B
# C --> B
# A --> C
# B --> A
# B --> C
# A --> C
# move(2, 'A', 'B', 'C')

# for i in range(3):
#     print(i)


# def trim(s):
#     if s == '':
#         return ''
#
#     if s[0] == ' ':
#         return trim(s[1:])
#     if s[-1] == ' ':
#         return trim(s[:-1])
#     return s


# 测试:
# if trim('hello  ') != 'hello':
#     print('测试失败!')
# elif trim('  hello') != 'hello':
#     print('测试失败!')
# elif trim('  hello  ') != 'hello':
#     print('测试失败!')
# elif trim('  hello  world  ') != 'hello  world':
#     print('测试失败!')
# elif trim('') != '':
#     print('测试失败!')
# elif trim('    ') != '':
#     print('测试失败!')
# else:
#     print('测试成功!')

# def findMinAndMax(L):
#     if len(L) == 0:
#         return None, None
#     mi = L[0]
#     ma = L[0]
#     for i in L:
#         if mi > i:
#             mi = i
#             continue
#         if ma < i:
#             ma = i
#     return mi, ma


# 测试
# if findMinAndMax([]) != (None, None):
#     print('测试失败!')
# elif findMinAndMax([7]) != (7, 7):
#     print('测试失败!')
# elif findMinAndMax([7, 1]) != (1, 7):
#     print('测试失败!')
# elif findMinAndMax([7, 1, 3, 9, 5]) != (1, 9):
#     print('测试失败!')
# else:
#     print('测试成功!')

# L2 = [x for x in L if isinstance(x, str)]

# def fib(max):
#     n, a, b = 0, 0, 1
#     while n < max:
#         # print(b)
#         yield b
#         a, b = b, a + b
#         n += 1
#     return 'Done'


# g = fib(6)
#
# while True:
#     try:
#         x = next(g)
#         print('g:', x)
#     except StopIteration as e:
#         print('Generator return value:', e.value)
#         break

# def odd():
#     print('step 1')
#     yield 1
#     print('step 2')
#     yield 3
#     print('step 3')
#     yield 5
#
#
# o = odd()
# next(o)
# next(o)
# next(o)
# next(o)

# def triangles():
#     L = [1]
#     while True:
#         yield L
#         L = [1] + [L[i] + L[i + 1] for i in range(len(L) - 1)] + [1]

# def triangles():
#     L = [1]
#     while True:
#         yield L
#         x = L + [0]
#         y = [0] + L
#         L = [x[i] + y[i] for i in range(len(x))]


# 期待输出:
# [1]
# [1, 1]
# [1, 2, 1]
# [1, 3, 3, 1]
# [1, 4, 6, 4, 1]
# [1, 5, 10, 10, 5, 1]
# [1, 6, 15, 20, 15, 6, 1]
# [1, 7, 21, 35, 35, 21, 7, 1]
# [1, 8, 28, 56, 70, 56, 28, 8, 1]
# [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]
# n = 0
# results = []
# for t in triangles():
#     results.append(t)
#     n = n + 1
#     if n == 10:
#         break
#
# for t in results:
#     print(t)
#
# if results == [
#     [1],
#     [1, 1],
#     [1, 2, 1],
#     [1, 3, 3, 1],
#     [1, 4, 6, 4, 1],
#     [1, 5, 10, 10, 5, 1],
#     [1, 6, 15, 20, 15, 6, 1],
#     [1, 7, 21, 35, 35, 21, 7, 1],
#     [1, 8, 28, 56, 70, 56, 28, 8, 1],
#     [1, 9, 36, 84, 126, 126, 84, 36, 9, 1]
# ]:
#     print('测试通过!')
# else:
#     print('测试失败!')


# def add(x, y, f):
#     return f(x) + f(y)
#
#
# print(add(-5, 6, abs))

# def f(x):
#     return x ** 2
#
#
# r = map(f, list(range(10)))
# print(type(r))
# print(list(r))

from functools import reduce

# def fn(x, y):
#     return x * 10 + y
#
#
# def char2num(s):
#     digits = {'0': 1, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}
#     # return digits.get(s)
#     return digits[s]
#
#
# def str2int(s):
#     return reduce(lambda x, y: x * 10 + y, map(char2num, s))
#
#
# print(str2int('123'))

# print(reduce(fn, [1, 2, 3]))
# print(reduce(fn, map(char2num, '123')))

# def add(x, y):
#     return x + y
#
#
# print(reduce(add, [1, 2, 3]))
