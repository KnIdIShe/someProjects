#!/usr/bin/env python3
# -*- coding: utf-8 -*-

# Web App骨架

import logging

logging.basicConfig(level=logging.INFO)
from aiohttp import web

routes = web.RouteTableDef()


@routes.get('/')
def index(request):
    return web.Response(body=b'<h1>Awesome</h1>', content_type='text/html')


def init():
    app = web.Application()
    app.router.add_routes(routes)

    logging.info('server started at http://127.0.0.1:9000...')
    web.run_app(app, host='127.0.0.1', port=9000)


if __name__ == '__main__':
    init()
