var gulp = require('gulp');
var browserSync = require('browser-sync').create();
var cleanCSS = require('gulp-clean-css');
var cleanJS = require('gulp-minify');
var rename = require("gulp-rename");
const minifyImages = require('gulp-imagemin');

gulp.task('browserSync', function() {
	browserSync.init({
		server: {
			baseDir: './'
		},
	})
})

gulp.task('minify-css', function() {
	return gulp.src('preCSS/*.css')
		.pipe(cleanCSS({keepSpecialComments: 1}))
		.pipe(gulp.dest('css'));
});

gulp.task('minify-js', function() {
  gulp.src('preJS/*.js')
    .pipe(cleanJS({
        exclude: ['tasks'],
        ignoreFiles: ['.combo.js', '-min.js']
    }))
	.pipe(rename({ suffix: '' }))
    .pipe(gulp.dest('js'))
});

gulp.task('minify-images', () =>
    gulp.src('preImg/*')
        .pipe(minifyImages())
        .pipe(gulp.dest('images'))
);