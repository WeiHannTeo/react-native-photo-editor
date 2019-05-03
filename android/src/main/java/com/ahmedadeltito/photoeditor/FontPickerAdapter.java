package com.ahmedadeltito.photoeditor;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ActionBar.LayoutParams;
import android.widget.TextView;

import android.graphics.Typeface;

import java.util.List;

import org.w3c.dom.Text;

import ui.photoeditor.R;

/**
 * Created by Ahmed Adel on 5/8/17.
 */

public class FontPickerAdapter extends RecyclerView.Adapter<FontPickerAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<Typeface> fontPickerFonts;
    private OnFontPickerClickListener onFontPickerClickListener;

    public FontPickerAdapter(@NonNull Context context, @NonNull List<Typeface> fontPickerFonts) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.fontPickerFonts = fontPickerFonts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.font_picker_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            buildFontPickerView( (TextView) holder.fontPickerView, fontPickerFonts.get(position) );
        }
    }

    @Override
    public int getItemCount() {
        return fontPickerFonts.size();
    }

    private void buildFontPickerView(TextView textView, Typeface fontCode) {
        textView.setTypeface(fontCode);
        if(fontCode.equals(fontPickerFonts.get(0))){
            textView.setText("Default");
        }
        if(fontCode.equals(fontPickerFonts.get(1))){
            textView.setText("Ailerons");
        }
        if(fontCode.equals(fontPickerFonts.get(2))){
            textView.setText("Athene");
        }
        if(fontCode.equals(fontPickerFonts.get(3))){
            textView.setText("Break");
        }
        if(fontCode.equals(fontPickerFonts.get(4))){
            textView.setText("Fountain");
        }
        if(fontCode.equals(fontPickerFonts.get(5))){
            textView.setText("Gabriola");
        }
        if(fontCode.equals(fontPickerFonts.get(6))){
            textView.setText("Grand Hotel");
        }
        if(fontCode.equals(fontPickerFonts.get(7))){
            textView.setText("Kano");
        }
        if(fontCode.equals(fontPickerFonts.get(8))){
            textView.setText("Lemon Cookie");
        }
        if(fontCode.equals(fontPickerFonts.get(9))){
            textView.setText("Le Super");
        }
        if(fontCode.equals(fontPickerFonts.get(10))){
            textView.setText("Minaxi Hairline");
        }
        if(fontCode.equals(fontPickerFonts.get(11))){
            textView.setText("Minik Bold");
        }
        if(fontCode.equals(fontPickerFonts.get(12))){
            textView.setText("Quentin");
        }
        if(fontCode.equals(fontPickerFonts.get(13))){
            textView.setText("Rainwood");
        }
        if(fontCode.equals(fontPickerFonts.get(14))){
            textView.setText("Sacramento");
        }
        if(fontCode.equals(fontPickerFonts.get(15))){
            textView.setText("Signatura Monoline");
        }
        if(fontCode.equals(fontPickerFonts.get(16))){
            textView.setText("Sophia");
        }
        if(fontCode.equals(fontPickerFonts.get(16))){
            textView.setText("The Salvador Condensed");
        }
        if(fontCode.equals(fontPickerFonts.get(16))){
            textView.setText("Verona Lotte");
        }
    }

    public void setOnFontPickerClickListener(OnFontPickerClickListener onFontPickerClickListener) {
        this.onFontPickerClickListener = onFontPickerClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView fontPickerView;
        public ViewHolder(View itemView) {
            super(itemView);
            fontPickerView = (TextView) itemView.findViewById(R.id.font_picker_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onFontPickerClickListener != null)
                        onFontPickerClickListener.onFontPickerClickListener(fontPickerFonts.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnFontPickerClickListener {
        void onFontPickerClickListener(Typeface fontCode);
    }
}
