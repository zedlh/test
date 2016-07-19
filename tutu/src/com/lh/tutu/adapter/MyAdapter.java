package com.lh.tutu.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.lh.tutu.R;
import com.lh.tutu.app.MyApplication;
import com.lh.tutu.entity.Item;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private List<Item> items;
	private RequestQueue queue;

	public MyAdapter(Context context, List<Item> items) {
		super();
		this.context = context;
		this.items = items;
		queue = MyApplication.getHttpQueue();
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Item getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Item item = getItem(position);
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item, null);
			holder = new ViewHolder();
			holder.ivPic = (ImageView) convertView.findViewById(R.id.iv_pic);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();

		// º”‘ÿÕº∆¨
		BitmapCache bitmapCache = new BitmapCache();
		ImageLoader imageLoader = new ImageLoader(queue, bitmapCache);

		ImageListener listener = ImageLoader.getImageListener(holder.ivPic,
				R.drawable.ic_launcher, R.drawable.ic_launcher);

		imageLoader.get(item.getImage_url(), listener,500,700);

		return convertView;
	}

	class ViewHolder {
		ImageView ivPic;
	}

	public class BitmapCache implements ImageCache {
		private LruCache<String, Bitmap> mCache;

		public BitmapCache() {
			int maxSize = 10 * 1024 * 1024;
			mCache = new LruCache<String, Bitmap>(maxSize) {
				@Override
				protected int sizeOf(String key, Bitmap bitmap) {
					return bitmap.getRowBytes() * bitmap.getHeight();
				}
			};
		}

		@Override
		public Bitmap getBitmap(String url) {
			return mCache.get(url);
		}

		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			mCache.put(url, bitmap);
		}
	}

}
