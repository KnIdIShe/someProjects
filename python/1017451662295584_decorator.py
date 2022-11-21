# -*- coding: utf-8 -*-

# 装饰器

# import functools


# def log(func):
#     def wrapper(*args, **kw):
#         print('call %s():' % func.__name__)
#         return func(*args, **kw)
#
#     return wrapper


# def log(text):
#     def decorator(func):
#         @functools.wraps(func)
#         def wrapper(*args, **kw):
#             print('%s %s():' % (text, func.__name__))
#             return func(*args, **kw)
#
#         return wrapper
#
#     return decorator
#
#
# # @log
# @log('execute')
# def now():
#     print('2022年2月28日 09点30分')


# f = now
# f()

# print(now.__name__)

#
# print(now.__name__)
# print(f.__name__)


# test 1
# 请设计一个decorator，它可作用于任何函数上，并打印该函数的执行时间：

# import time, functools
#
#
# def metric(fn):
#     @functools.wraps(fn)
#     def wrapper(*args, **kw):
#         start = time.perf_counter()
#         result = fn(*args, **kw)
#         t = time.perf_counter() - start
#         print('%s executed in %s ms' % (fn.__name__, t * 1000))
#         return result
#
#     return wrapper
#
#
# # 测试
# @metric
# def fast(x, y):
#     time.sleep(0.0012)
#     return x + y;
#
#
# @metric
# def slow(x, y, z):
#     time.sleep(0.1234)
#     return x * y * z;
#
#
# f = fast(11, 22)
# s = slow(11, 22, 33)
# if f != 33:
#     print('测试失败!')
# elif s != 7986:
#     print('测试失败!')


# test 2
# 编写一个decorator，能在函数调用的前后打印出'begin call'和'end call'的日志。

# import functools
#
#
# def log(fn):
#     @functools.wraps(fn)
#     def wrapper(*args, **kwargs):
#         print('begin call')
#         result = fn(*args, **kwargs)
#         print('end call')
#         return result
#
#     return wrapper
#
#
# @log
# def fn():
#     print('hh')
#
#
# fn()


# test 3
# 再思考一下能否写出一个@log的decorator，使它既支持：
#
# @log
# def f():
#     pass
# 又支持：
#
# @log('execute')
# def f():
#     pass

import functools


def log(input=None):
    # @log, 不手动传参, 参数为函数名
    if callable(input):
        func = input

        @functools.wraps(func)
        def wrapper(*args, **kw):
            print('%s():' % func.__name__)
            return func(*args, **kw)

        return wrapper

    # @log('execute')
    elif isinstance(input, str):
        def decorator(func):
            @functools.wraps(func)
            def wrapper(*args, **kw):
                print('%s %s():' % (input, func.__name__))
                return func(*args, **kw)

            return wrapper

        return decorator

    # 其他参数
    else:
        def decorator(func):
            @functools.wraps(func)
            def wrapper(*args, **kw):
                print('wrong args')
                return func(*args, **kw)

            return wrapper

        return decorator


# @log('aaa')
# @log
@log([1, 2, 3])
def fn():
    print('hh')


fn()
