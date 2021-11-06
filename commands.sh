find ./ -name '*lastUpdated' -type f -exec echo {} \;

# nginx 快速启动
# 创建work/conf, work/logs 目录
# 创建 work/conf/nginx.conf文件
# cd到work/下，启动nginx
nginx -p `pwd`/ -c conf/nginx.conf