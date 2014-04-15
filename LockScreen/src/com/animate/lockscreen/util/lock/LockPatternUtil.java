package com.animate.lockscreen.util.lock;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.animate.lockscreen.util.LockPreference;
import com.animate.lockscreen.widget.lock.LockPatternView.Cell;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

// TODO: Auto-generated Javadoc
/**
 * The Class LockPatternUtil.
 */
public class LockPatternUtil {

	/** The Constant PATTERN_UNLOCK_KEY. */
	public static final String PATTERN_UNLOCK_KEY = "pattern_unlock_key";
	
	/**
	 * Sets the pattern unlock.
	 *
	 * @param pattern the new pattern unlock
	 */
	public static void savePatternUnlock(List<Cell> pattern){
		Gson gson = new Gson();
		if (pattern != null) {
			List<Cell> currentPattern = new ArrayList<Cell>(pattern);
			String json = gson.toJson(currentPattern);
			LockPreference.getInstance().putString(PATTERN_UNLOCK_KEY, json);
		}
	}
	
	
	/**
	 * Gets the pattern unlock.
	 *
	 * @return the pattern unlock
	 */
	private static List<Cell> getPatternUnlock(){
		Gson gson = new Gson();
		String json = LockPreference.getInstance().getStringValue(PATTERN_UNLOCK_KEY, "");
		Type type = new TypeToken<List<Cell>>() {}.getType();
		return gson.fromJson(json, type);
	}
	
	/**
	 * Check pattern unlock.
	 *
	 * @param pattern the pattern
	 * @return true, if successful
	 */
	public static boolean checkPatternUnlock(List<Cell> pattern){
		List<Cell> currentPattern = getPatternUnlock();
//		if(pattern==null || currentPattern == null) 
//			return false;
//		if(currentPattern.size() == pattern.size()&&currentPattern.containsAll(pattern)){
//			return true;
//		}
//		return false;
		return comparePattern(currentPattern, pattern);
	}
	
	
	/**
	 * Compare pattern.
	 *
	 * @param srcPattern the src pattern
	 * @param desPattern the des pattern
	 * @return true, if successful
	 */
	private static boolean comparePattern(List<Cell> srcPattern,List<Cell> desPattern){
		if(srcPattern==null||desPattern==null||srcPattern.size()!=desPattern.size())
			return false;
		
		int patternSize = srcPattern.size();
		for(int i=0;i<patternSize;i++){
			Cell srcCell = srcPattern.get(i);
			Cell desCell = desPattern.get(i);
			if(srcCell.getRow()!=desCell.getRow() || srcCell.getColumn()!=desCell.getColumn()){
				return false;
			}
		}
		return true;
	}
	
}
