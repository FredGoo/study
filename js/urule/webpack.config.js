/**
 * @author fred
 * 2018-04-23
 * Base on Webpack4
 */
const path = require('path');

module.exports = {
    mode: 'development',

    resolve: {
        extensions: ['*', '.js', '.json']
    },

    devServer: {
        contentBase: path.join(__dirname, 'src'),
        compress: true,
        port: 9001
    }
};