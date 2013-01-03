package info.lamatricexiste.network.utils;
//package info.lamatricexiste.network.Utils;
//
//import info.lamatricexiste.network.R;
//import info.lamatricexiste.network.Network.HostBean;
//import info.lamatricexiste.network.Network.NetInfo;
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.PorterDuff.Mode;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//// Custom ArrayAdapter
//public class HostsAdapter extends ArrayAdapter<Void> {
//	LayoutInflater mInflater;
//
//	public HostsAdapter(Context ctxt) {
//		super(ctxt, R.layout.list_host, R.id.list);
//		mInflater = LayoutInflater.from(ctxt);
//	}
//
//	@Override
//	public View getView(final int position, View convertView, ViewGroup parent) {
//		ViewHolder holder;
//		if (convertView == null) {
//			convertView = mInflater.inflate(R.layout.list_host, null);
//			holder = new ViewHolder();
//			holder.host = (TextView) convertView.findViewById(R.id.list);
//			holder.mac = (TextView) convertView.findViewById(R.id.mac);
//			holder.vendor = (TextView) convertView.findViewById(R.id.vendor);
//			holder.logo = (ImageView) convertView.findViewById(R.id.logo);
//			holder.userGivenName = (TextView) convertView.findViewById(R.id.userName);
//			convertView.setTag(holder);
//		} else {
//			holder = (ViewHolder) convertView.getTag();
//		}
//
//		final HostBean host = hosts.get(position);
//
//		if (host.deviceType == HostBean.TYPE_GATEWAY) {
//			holder.logo.setImageResource(R.drawable.ic_network_device_internet);
//		} else if (host.isAlive == 1 || !host.hardwareAddress.equals(NetInfo.NOMAC)) {
//			holder.logo.setImageResource(host.icon);
//			holder.logo.setColorFilter(null);
//		} else {
//			holder.logo.setImageResource(host.icon);
//			holder.logo.setColorFilter(Color.parseColor("#DD0000"), Mode.MULTIPLY);
//		}
//
//		if (host.hostname != null && !host.hostname.equals(host.ipAddress)) {
//			holder.host.setText(host.hostname + " (" + host.ipAddress + ")");
//		} else {
//			holder.host.setText(host.ipAddress);
//		}
//
//		if (!host.hardwareAddress.equals(NetInfo.NOMAC)) {
//			holder.mac.setText(host.hardwareAddress);
//			if(host.nicVendor != null){
//				holder.vendor.setText(host.nicVendor);
//			} else {
//				holder.vendor.setText(R.string.info_unknown);
//			}
//			holder.mac.setVisibility(View.VISIBLE);
//			holder.vendor.setVisibility(View.VISIBLE);
//		} else {
//			holder.mac.setVisibility(View.GONE);
//			holder.vendor.setVisibility(View.GONE);
//		}
//
//		if(host.userGivenName != null){
//			holder.userGivenName.setText(host.userGivenName);
//			holder.userGivenName.setVisibility(View.VISIBLE);
//		} else {
//			holder.userGivenName.setVisibility(View.GONE);
//		}
//
//		return convertView;
//	}
//
//	static class ViewHolder {
//		TextView host;
//		TextView mac;
//		TextView vendor;
//		TextView userGivenName;
//		ImageView logo;
//	}
//}
