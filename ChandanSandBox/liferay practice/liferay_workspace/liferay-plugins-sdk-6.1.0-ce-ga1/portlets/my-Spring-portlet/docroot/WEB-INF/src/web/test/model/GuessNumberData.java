package web.test.model;

import java.io.Serializable;
import java.util.Random;

public class GuessNumberData implements Serializable
{
	/**
	 * Instances of this will probably be stored in the PortletSession.
	 * And therefore this class, as a best practice, should be
	 * Serializable. 
	 */
	private static final long serialVersionUID = 1L;

	private Random generator;
	private String answer;
	private int num;
	private String user;
	private int min;
	private int max;
	
	public GuessNumberData()
	{
		min = 0;
		max = 10;
		generator = new Random();
		user="chandan";
		resetNumber();
	}

	public void resetNumber()
	{
		int diff = max - min;
		num = (generator.nextInt(diff+1)) + min;
		answer="";
	}

	public void startGame(String username, String minimum, String maximum)
	{
		user = username;

		try {
			min = Integer.parseInt(minimum);
			max = Integer.parseInt(maximum);
		} catch(NumberFormatException nfe) {
			// If they give bad data then log the error but otherwise just
			// use the defaults of 0 and 10
			System.out.println("ERROR: " + nfe.getMessage());
		}

		resetNumber();
	}

	public boolean isCorrect()
	{
		int ans;
		try {
			ans = Integer.parseInt(answer);
		} catch (NumberFormatException nfe) {
			ans = -1;
		}

		return (num == ans);
	}

	public void setAnswer(String answer)
	{
		this.answer = answer;
	}

	public String getAnswer()
	{
		return answer;
	}

	public int getNumber()
	{
		return num;
	}

	public String getUsername()
	{
		return user;
	}

	public int getMinimum()
	{
		return min;
	}

	public int getMaximum()
	{
		return max;
	}
}
