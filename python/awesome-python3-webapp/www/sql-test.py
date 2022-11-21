#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# sql test

import orm, asyncio
from models import User, Blog, Comment


async def test(loop):
    await orm.create_pool(loop=loop, user='www-data', password='www-data', database='awesome')

    u = User(name='test', email='test@example.com', passwd='1234567890', image='about:blank')
    await u.save()
    # RuntimeError: Event loop is closed, 解决报错, 但数据可正常插入
    orm.__pool.close()
    await orm.__pool.wait_closed()


if __name__ == '__main__':
    loop = asyncio.get_event_loop()
    loop.run_until_complete(test(loop))
    loop.close()
