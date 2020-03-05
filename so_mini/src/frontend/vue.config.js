module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localshot:8080',
                changeOrigin: true,
                pathRewrite: {
                    '^/api': ''
                }
            }
        }
    }
}