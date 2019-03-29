/**
 * @author fred
 * 2018-04-23
 * Base on Webpack4
 */
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    mode: 'development',

    resolve: {
        extensions: ['*', '.js', '.json']
    },

    entry: {
        frame: './src/common/index.js',
    },

    output: {
        path: path.resolve('dist'),
        filename: '[name].bundle.js'
    },

    plugins: [
        new HtmlWebpackPlugin({
            filename: 'index.html',
            template: 'src/index.html',
            chunks: ["frame"]
        }),

        // 复制文件
        new CopyWebpackPlugin([
            {
                from: path.resolve(__dirname, 'src/vendor'),
                to: 'vendor'
                // ignore: ['.*']
            },
            {
                from: path.resolve(__dirname, 'src/css'),
                to: 'css'
                // ignore: ['.*']
            },
            {
                from: path.resolve(__dirname, 'src/js'),
                to: 'js'
                // ignore: ['.*']
            },
            {
                from: path.resolve(__dirname, 'src/fonts'),
                to: 'fonts'
            }
        ])
    ],

    devServer: {
        contentBase: path.join(__dirname, 'dist'),
        compress: true,
        port: 9001,
        proxy: {
            '/frule/api': {
                target: 'http://127.0.0.1:8080',
                changeOrigin: true,
                pathRewrite: {
                    '^': ''
                }
            }
        }

    }
};