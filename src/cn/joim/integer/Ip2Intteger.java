package cn.joim.integer;

public class Ip2Intteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputIp = "10.0.3.193";
		// 167773121 = 10.0.3.193

		long lResult = 0;
		try {
			lResult = ip2Long(inputIp);
		} catch (ErrorIpInputException e) {
			lResult = -1;
		}
		System.out.println("input : " + inputIp);
		if (lResult < 0) {

			System.out.println("errpr input.");
		} else {
			System.out.println("result : " + lResult);
			System.out.println("parse long to ip : " + parseLong2Ip(lResult));

		}

	}

	static String parseLong2Ip(long lInout) {
		
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append((lInout >> 24)).append(".");

		stringBuilder.append(((lInout & 0x00FFFFFF) >> 16)).append(".");

		stringBuilder.append(((lInout & 0x0000FFFF) >> 8)).append(".");

		stringBuilder.append(((lInout & 0x000000FF)));

		return stringBuilder.toString();
	}

	static long ip2Long(String inputIp) throws ErrorIpInputException {

		long result = 0;
		long ipContentArr[] = filterIpLong(inputIp);
		if (ipContentArr == null || ipContentArr.length <= 0) {
			throw new ErrorIpInputException("error content : " + inputIp);
		}
		for (int i = 0; i < ipContentArr.length; i++) {

			long tempItem = ipContentArr[i] << (8 * (ipContentArr.length - 1 - i));
			result += tempItem;
		}
		return result;
	}

	static long[] filterIpLong(String inputIp) {

		try {
			String arr[] = inputIp.split("\\.");
			long resultArr[] = new long[arr.length];
			for (int i = 0; i < arr.length; i++) {
				resultArr[i] = Long.valueOf(arr[i]);
			}
			return resultArr;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return null;
	}

	public static class ErrorIpInputException extends Exception {

		public ErrorIpInputException(String message) {
			super(message);
		}
	}
}
