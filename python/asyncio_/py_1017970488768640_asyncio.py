#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# asyncio

# import asyncio


# @asyncio.coroutine
# async def hello():
#     print('hello world')
#     # 异步调用asyncio.sleep(1):
#     # r = yield from asyncio.sleep(1)
#     r = await asyncio.sleep(1)
#     print('hello again')
#
#
# # 获取EventLoop:
# loop = asyncio.get_event_loop()
# # 执行coroutine
# loop.run_until_complete(hello())
# loop.close()


# import threading, asyncio
#
#
# async def hello():
#     print('hello world! (%s)' % threading.currentThread().name)
#     # 异步调用asyncio.sleep(1):
#     # r = yield from asyncio.sleep(1)
#     await asyncio.sleep(1)
#     print('hello again! (%s)' % threading.currentThread().name)
#
#
# # 获取EventLoop:
# loop = asyncio.get_event_loop()
# # 执行coroutine
# tasks = [hello(), hello()]
# loop.run_until_complete(asyncio.wait(tasks))
# loop.close()


# 用asyncio的异步网络连接来获取sina、sohu和163的网站首页：
import asyncio


async def wget(host):
    print('wget %s...' % host)
    connect = asyncio.open_connection(host, 80)
    reader, writer = await connect
    header = 'GET / HTTP/1.0\r\nHost: %s\r\n\r\n' % host
    writer.write(header.encode('utf-8'))
    await writer.drain()
    while True:
        line = await reader.readline()
        if line == b'\r\n':
            break
        print('%s header > %s' % (host, line.decode('utf-8').rstrip()))
    # Ignore the body, close the socket
    writer.close()


# 获取EventLoop:
loop = asyncio.get_event_loop()
# 执行coroutine
tasks = [wget(host) for host in ['www.sina.com.cn', 'www.sohu.com', 'www.163.com']]
loop.run_until_complete(asyncio.wait(tasks))
loop.close()
