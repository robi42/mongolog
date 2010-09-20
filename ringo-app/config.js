exports.urls = [
    ['/', require('actions')],
];

exports.middleware = [
    require('ringo/middleware/gzip').middleware,
    require('ringo/middleware/etag').middleware,
    require('ringo/middleware/static').middleware(module.resolve('public')),
    require('ringo/middleware/responselog').middleware,
    require('ringo/middleware/error').middleware,
    require('ringo/middleware/notfound').middleware,
];

exports.app = require('ringo/webapp').handleRequest;

exports.macros = [
    require('ringo/skin/macros'),
    require('ringo/skin/filters'),
];

exports.jars = [
    module.directory + "../lib/scala_2.7.7/scala-library.jar",
    module.directory + "../lib_managed/scala_2.7.7/compile/lift-common-2.0.jar",
    module.directory + "../lib_managed/scala_2.7.7/compile/lift-json-2.0.jar",
    module.directory + "../lib_managed/scala_2.7.7/compile/lift-mongodb-2.0.jar",
    module.directory + "../lib_managed/scala_2.7.7/compile/mongo-java-driver-2.0.jar",
    module.directory + "../lib_managed/scala_2.7.7/compile/paranamer-2.0.jar",
    module.directory + "../target/scala_2.7.7/mongolog_2.7.7-1.0.jar"
];

exports.charset = 'UTF-8';
exports.contentType = 'text/html';
