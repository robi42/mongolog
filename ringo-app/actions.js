var {Response} = require("ringo/webapp/response");
importPackage(com.robert42.mongolog);

exports.index = function (req) {
    return Response.skin(module.resolve("skins/index.html"), {
        title: "Home",
        posts: JSON.parse(Posts.all()).reverse()
    });
};

exports.show = function (req, id) {
    return Response.skin(module.resolve("skins/show.html"), {
        title: "Post",
        post: JSON.parse(Posts.get(id))
    });
};

exports.create = {
    POST: function (req) {
        Posts.create(JSON.stringify({body: req.params.body}));
        return Response.redirect('/');
    }
};
