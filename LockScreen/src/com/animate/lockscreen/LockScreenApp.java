package com.animate.lockscreen;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.animate.lockscreen.util.UniversalImageLoader;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public class LockScreenApp extends Application{

	 /** The m context. */
		private static Context mContext;
	    
		/** The cache limit for image. */
		public static int CACHE_LIMIT_FOR_IMAGE;
	    
		/** The app context. */
		public static Context APP_CONTEXT;
	    
		/* (non-Javadoc)
		 * @see android.app.Application#onCreate()
		 */
		@Override
	    public void onCreate() {
	        super.onCreate();
	        mContext = this;
	        int cacheLimit =
	                1024 * 1024 * (((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE))
	                        .getMemoryClass() / 4);
	        CACHE_LIMIT_FOR_IMAGE = cacheLimit;
	        APP_CONTEXT = getApplicationContext();
	        initImageLoader(getApplicationContext());
	    }

	    /**
		 * Gets the app context.
		 *
		 * @return the app context
		 */
		public static Context getAppContext() {
	        return mContext;
	    }

	    /* (non-Javadoc)
		 * @see android.app.Application#onLowMemory()
		 */
		@Override
	    public void onLowMemory() {
	        super.onLowMemory();
	    }

	    /** The Constant DEVELOPER_MODE. */
		public static final boolean DEVELOPER_MODE = false;

	    /**
		 * Inits the image loader.
		 *
		 * @param context the context
		 */
		@SuppressWarnings("unused")
	    public static void initImageLoader(Context context) {
	        // This configuration tuning is custom. You can tune every option, you
	        // may tune some of
	        // them,
	        // or you can create default configuration by
	        // ImageLoaderConfiguration.createDefault(this);
	        // method.
	        DisplayImageOptions options =
	                new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true)
	                        .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
	                        .bitmapConfig(Bitmap.Config.RGB_565)
	                        .cacheInMemory(true)
							.cacheOnDisc(true)
	                        .build();

	        ImageLoaderConfiguration config =
	                new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)
	                        .denyCacheImageMultipleSizesInMemory().threadPoolSize(3)
	                        .discCacheFileNameGenerator(new Md5FileNameGenerator())
	                        .defaultDisplayImageOptions(options) // in common
	                        .memoryCache(new WeakMemoryCache()).build();
	        // Initialize ImageLoader with configuration.
	        UniversalImageLoader.getInstance().init(config);
	    }
}
