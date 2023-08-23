package com.bank.details.proxy;

public class Limits {

	private int minimum;
	private int maximum;
	private int port;

	public Limits(int minimum, int maximum, int port) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
		this.port = port;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Limits [minimum=" + minimum + ", maximum=" + maximum + ", port=" + port + "]";
	}

}
