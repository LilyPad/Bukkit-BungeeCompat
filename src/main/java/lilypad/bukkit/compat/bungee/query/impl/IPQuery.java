package lilypad.bukkit.compat.bungee.query.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;

import org.bukkit.Server;
import org.bukkit.entity.Player;

import lilypad.bukkit.compat.bungee.query.Query;
import lilypad.bukkit.compat.bungee.util.Constants;

public class IPQuery implements Query {

	private Server server;
	
	public IPQuery(Server server) {
		this.server = server;
	}

	public void execute(Player player, String id, DataInput input) throws Exception {
		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		DataOutput output = new DataOutputStream(byteArrayOutput);
		output.writeUTF("IP");
		output.writeUTF(player.getAddress().getAddress().getHostAddress());
		output.writeInt(player.getAddress().getPort());
		this.server.getMessenger().dispatchIncomingMessage(player, Constants.channel, byteArrayOutput.toByteArray());
	}

	public String getId() {
		return "IP";
	}

}
