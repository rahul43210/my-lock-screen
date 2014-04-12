package com.animate.lockscreen.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animate.lockscreen.R;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseFragment.
 */
public abstract class BaseFragment extends Fragment{
	
	/** The m view screen container. */
	protected View mViewScreenContainer;
	
	/** The m content view. */
	protected View mContentView;
	
	/** The m header container. */
	protected ViewGroup mHeaderContainer;
	
	/** The m footer container. */
	protected ViewGroup mFooterContainer;
	
	/** The m content container. */
	protected ViewGroup mContentContainer;

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// --------------Init Screen--------------
		// ----init contanier view
		LayoutInflater inflater = LayoutInflater.from(getActivity());
		this.mViewScreenContainer = inflater.inflate(R.layout.base_screen, null);

		mHeaderContainer = (ViewGroup) this.mViewScreenContainer.findViewById(R.id.layout_header);
		mFooterContainer = (ViewGroup) this.mViewScreenContainer.findViewById(R.id.layout_footer);
		mContentContainer = (ViewGroup) this.mViewScreenContainer.findViewById(R.id.layout_content);
		
		// ----add header view
		View headerView = this.onCreateHeaderView(inflater, mHeaderContainer);
		if (headerView != null) {
			mHeaderContainer.addView(headerView);
		}
		
		View footerView = this.onCreateFooterView(inflater, mFooterContainer);
		if(footerView!=null){
			mFooterContainer.addView(footerView);
		}

		// ----add content view
		this.mContentView = this.onCreateContentView(inflater, mContentContainer);
		if (this.mContentView != null) {
			mContentContainer.addView(this.mContentView);
		}
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (this.mViewScreenContainer.getParent() != null) {
			((ViewGroup) this.mViewScreenContainer.getParent()).removeView(this.mViewScreenContainer);
		}

		return (View) this.mViewScreenContainer;
	}


	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onDestroy()
	 */
	@Override
	public void onDestroy() {
		this.mContentView = null;
		this.mHeaderContainer = null;
		this.mContentContainer = null;
		this.mViewScreenContainer = null;
		super.onDestroy();
	}

	/**
	 * Gets the content view.
	 *
	 * @return the content view
	 */
	public View getContentView(){
		return mContentView;
	}
	/**
	 * On create header view.
	 *
	 * @param inflater the inflater
	 * @param container the container
	 * @return the view
	 */
	protected View onCreateHeaderView(LayoutInflater inflater, ViewGroup container){
		return null;
	}
	
	
	/**
	 * On create footer view.
	 *
	 * @param inflater the inflater
	 * @param container the container
	 * @return the view
	 */
	protected View onCreateFooterView(LayoutInflater inflater, ViewGroup container){
		return null;
	}
	
	/**
	 * On create content view.
	 *
	 * @param inflater the inflater
	 * @param container the container
	 * @return the view
	 */
	protected abstract View onCreateContentView(LayoutInflater inflater, ViewGroup container);
}
