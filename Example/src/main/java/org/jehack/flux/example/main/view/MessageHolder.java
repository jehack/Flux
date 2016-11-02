package org.jehack.flux.example.main.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.jehack.flux.example.ExampleFlux;
import org.jehack.flux.example.R;
import org.jehack.flux.example.main.model.MessageModel;

public class MessageHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

    public ImageView messageIcon;

    public TextView message;

    public MessageHolder(View itemView) {
        super(itemView);
        messageIcon = (ImageView) itemView.findViewById(R.id.message_icon);
        message = (TextView) itemView.findViewById(R.id.message_text);
        itemView.setOnClickListener(this);
    }

    public void bind(MessageModel model) {
        message.setText(model.getMessage());
        itemView.setTag(model.getMessage());
    }

    @Override
    public void onClick(View view) {
        ExampleFlux.getActions().getMain().showMessage((String) view.getTag());
    }
}
