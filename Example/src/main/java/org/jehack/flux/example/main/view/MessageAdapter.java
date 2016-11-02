package org.jehack.flux.example.main.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jehack.flux.example.R;
import org.jehack.flux.example.main.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

    private List<MessageModel> messageModels;
    private LayoutInflater layoutInflater;

    public MessageAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        messageModels = new ArrayList<>();
    }

    public void update(List<MessageModel> messageModels) {
        this.messageModels = messageModels;
        notifyDataSetChanged();
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_message, parent, false);

        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {

        MessageModel model = messageModels.get(position);

        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }
}
