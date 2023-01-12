//
//  SearchbarView.swift
//  iosApp
//
//  Created by Bruno Andres Fontes on 11/1/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SearchbarView: View {
    @State var text: String = ""
    @State private var isEditing = false
    let action: (_ text: String) -> Void
    var body: some View {
        HStack {
            if #available(iOS 15.0, *) {
                TextField("Search ...", text: $text)
                    .keyboardType(.webSearch)
                    .padding(7)
                    .padding(.horizontal, 25)
                    .background(Color(.systemGray6))
                    .cornerRadius(8)
                    .overlay(
                        HStack {
                            Image(systemName: "magnifyingglass")
                                .foregroundColor(.gray)
                                .frame(minWidth: 0, maxWidth: .infinity, alignment: .leading)
                                .padding(.leading, 8)

                            if isEditing {
                                Button(action: {
                                    self.text = ""
                                }) {
                                    Image(systemName: "multiply.circle.fill")
                                        .foregroundColor(.gray)
                                        .padding(.trailing, 8)
                                }
                            }
                        }
                    )
                    .onSubmit {
                        action(text)
                    }
                    .padding(.horizontal, 10)
                    .onTapGesture {
                        self.isEditing = true
                        print($text)
                    }
            } else {
                // Fallback on earlier versions
            }

            if isEditing {
                Button(action: {
                    self.isEditing = false
                    self.text = ""
                    UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
                }) {
                    Text("Cancel")
                }
                .padding(.trailing, 10)
                .transition(.move(edge: .trailing))
                .animation(.default)
            }
        }
    }
}
