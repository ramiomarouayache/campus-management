package utils;

public interface Callback<T>{
	public void onSuccess(T data);
	public void onFailure(String message,Exception exception);
}
