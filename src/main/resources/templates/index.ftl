<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layui 搭建项目</title>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body>

<!-- 你的HTML代码 -->
<h1>欢迎使用layui搭建项目</h1>

<script src="../static/layui/layui.js"></script>
<script>
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer, form = layui.form;
        layer.msg('Hello World');
    });
</script>
</body>
</html>